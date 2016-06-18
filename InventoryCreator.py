import xml.etree.ElementTree as ET
import xml.dom.minidom as DM
import sys


def main(root):
	

	my_input = None
	while isinstance(my_input,int) is False :
		my_input = input("What would you like to standardize the inventory amount to be: ")
	
	print(my_input)
	item_name = None

	while item_name is not "q" :
		item_name = raw_input("What item would you like to add to the inventory: ")
		if item_name is not "q" :
			print(type(item_name))
			createChild(root, item_name, str(my_input))

def createChild(root, item_name, amount):
	doc = ET.SubElement(root, "item", name = item_name)
	ET.SubElement(doc, "Amount").text = amount

	

root = ET.Element("Inventory")
main(root)


output_file = open( 'Inventory.xml', 'w' )
output_file.write( '<?xml version="1.0"?>' )
output_file.write( DM.parseString(ET.tostring( root )).toprettyxml(indent="	") )
output_file.close()