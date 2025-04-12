import ifcopenshell
import ifcopenshell.geom
import ifcopenshell.util.shape 
ifc_file = ifcopenshell.open("AC20-FZK-Haus.ifc")

settings = ifcopenshell.geom.settings()

print("ROOMS:")
for space in ifc_file.by_type("IfcSpace"):

    connected_doors = []
    for rel in ifc_file.by_type("IfcRelSpaceBoundary"):
        if rel.RelatingSpace == space:
            element = rel.RelatedBuildingElement
            if element and element.is_a("IfcDoor"):
                connected_doors.append(element.Name)

    try:
        shape = ifcopenshell.geom.create_shape(settings, space)
        area = round(ifcopenshell.util.shape.get_area(shape.geometry), 2)
        volume = round(ifcopenshell.util.shape.get_volume(shape.geometry), 2)
    except:
        area = None
        volume = None

    room_info = {
        "GUID": space.GlobalId,
        "Name": space.Name,
        "LongName": space.LongName,
        "NetFloorArea": area,
        "NetVolume": volume,
        "ConnectedDoors": connected_doors
    }
    print(room_info)


    
print("\nDOORS:")
for door in ifc_file.by_type("IfcDoor"):
    try:
        shape = ifcopenshell.geom.create_shape(settings, door)
        area = round(ifcopenshell.util.shape.get_area(shape.geometry), 2)
        volume = round(ifcopenshell.util.shape.get_volume(shape.geometry), 2)
    except:
        area = None
        volume = None

    door_info = {
        "GUID": door.GlobalId,
        "Name": door.Name,
        "OverallWidth": getattr(door, "OverallWidth", None),
        "OverallHeight": getattr(door, "OverallHeight", None),
        "Area": area,
        "Volume": volume,
    }
    print(door_info)