import ifcopenshell
import ifcopenshell.geom
import ifcopenshell.util.shape as Shape
import ifcopenshell.util.element as Element
import json
import pprint
pp=pprint.PrettyPrinter()

# Load the IFC file
ifc_file = ifcopenshell.open("AC20-FZK-Haus.ifc")

# Initialize geometry settings
settings = ifcopenshell.geom.settings()

# List to store room information
rooms_data = []

# Iterate over all IfcSpace elements
for space in ifc_file.by_type("IfcSpace"):
    # Extract basic attributes
    guid = space.GlobalId
    name = space.Name
    long_name = space.LongName

    # Initialize area and volume
    area = None
    volume = None

    # Attempt to compute area and volume
    try:
        shape = ifcopenshell.geom.create_shape(settings, space)
        area = round(Shape.get_area(shape.geometry), 2)
        volume = round(Shape.get_volume(shape.geometry), 2)
    except:
        pass  # Geometry computation failed; area and volume remain None

    # Retrieve property set using ifcopenshell.util.element
    airconditioning = Element.get_pset(space, "Pset_SpaceThermalRequirements", "AirConditioning")

    # Identify connected doors via IfcRelSpaceBoundary
    connected_doors = []
    for rel in ifc_file.by_type("IfcRelSpaceBoundary"):
        if rel.RelatingSpace == space:
            element = rel.RelatedBuildingElement
            if element and element.is_a("IfcDoor"):
                connected_doors.append(element.Name)

    # Compile room information
    room_info = {
        "AirConditioning": airconditioning,
        "ConnectedDoors": connected_doors,
        "GUID": guid,
        "LongName": long_name,
        "Name": name,
        "NetFloorArea": area,
        "NetVolume": volume
    }

    # Add to the list
    rooms_data.append(room_info)
    pp.pprint(room_info)



# List to store door information
doors_data = []

# Iterate over all IfcDoor elements
for door in ifc_file.by_type("IfcDoor"):
    guid = door.GlobalId
    name = door.Name
    width = getattr(door, "OverallWidth", None)
    height = getattr(door, "OverallHeight", None)

    # Get property
    u_value = Element.get_pset(door, "Pset_DoorCommon", "ThermalTransmittance")
    storey = Element.get_container(door).Name if Element.get_container(door) else None


    door_info = {
        "GUID": guid,
        "Name": name,
        "OverallWidth": width,
        "OverallHeight": height,
        "ThermalTransmittance": u_value,
        "Storey": storey
    }

    doors_data.append(door_info)
    pp.pprint(door_info)


# Combine rooms and doors into one JSON structure
combined_data = {
    "Rooms": rooms_data,
    "Doors": doors_data
}

# Write to JSON
with open("building_elements_output.json", "w", encoding="utf-8") as f:
    json.dump(combined_data, f, indent=4, ensure_ascii=False)

print("\n✅ Rooms and doors exported to 'building_elements_output.json'")