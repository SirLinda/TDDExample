/**
 * @author Senzo NKosi
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Agency agency = new Agency("BCIT Ltd");

        // Create the addresses
        Address address1 = new Address("1a", 777, "56th avenue", "surrey", "v7n2m8");
        Address address2 = new Address("123", 0, "main street", "west vancouver", "v7r2g2");
        Address address3 = new Address("456", 0, "elm street", "los angeles", "90210");
        Address address4 = new Address("44", 1111, "maple street", "vancouver", "v8y3r5");
        Address address5 = new Address("9", 99, "gretzky way", "toronto", "t6v7h3");
        Address address6 = new Address("b", 711, "country road", "maple ridge", "v8h5f5");
        Address address7 = new Address("8785", 0, "pinnacle avenue", "north vancouver", "v9u3h3");
        Address address8 = new Address("800", 0, "elm street", "los angeles", "90557");
        Address address9 = new Address("1515", 0, "main street", "west vancouver", "V8Y7R3");
        Address address10 = new Address("6", 60, "60th street", "burnaby", "v8u9b1");
        Address address11 = new Address("7h", 1500, "railway avenue", "richmond", "v9v5v4");
        Address address12 = new Address("333", 0, "elm street", "los angeles", "90111");

        // Create the properties
        Property property1 = new Property(499000.0, address1, 2, false, "residence", "abc123");
        Property property2 = new Property(5999999.0, address2, 5, true, "residence", "xyz789");
        Property property3 = new Property(2500000.0, address3, 6, true, "residence", "777def");
        Property property4 = new Property(1000000.0, address4, 1, false, "retail", "876tru");
        Property property5 = new Property(99999.0, address5, 1, false, "commercial", "9999");
        Property property6 = new Property(740100.0, address6, 3, false, "residence", "mr6789");
        Property property7 = new Property(15000000.0, address7, 20, true, "residence", "78444a");
        Property property8 = new Property(7100000.0, address8, 10, false, "residence", "mmm33");
        Property property9 = new Property(4000000.0, address9, 2, true, "commercial", "678T");
        Property property10 = new Property(700000.0, address10, 2, true, "retail", "y6yyy");
        Property property11 = new Property(840000.0, address11, 4, false, "commercial", "A1212");
        Property property12 = new Property(1600000.0, address12, 3, false, "residence", "9000a");

        // Add properties to the agency
        agency.addProperty(property1);
        agency.addProperty(property2);
        agency.addProperty(property3);
        agency.addProperty(property4);
        agency.addProperty(property5);
        agency.addProperty(property6);
        agency.addProperty(property7);
        agency.addProperty(property8);
        agency.addProperty(property9);
        agency.addProperty(property10);
        agency.addProperty(property11);
        agency.addProperty(property12);

        // Sample test cases using agency methods
        System.out.println("Total property values: " + agency.getTotalPropertyValues());
        System.out.println("Properties with swimming pools: " + agency.getPropertiesWithPools());
        System.out.println("Properties between $1,000,000 and $5,000,000: " +
                agency.getPropertiesBetween(1000000.0, 5000000.0));
        System.out.println("Properties on Elm Street: " + agency.getPropertiesOn("elm street"));
        System.out.println("Properties with 2 to 5 bedrooms: " +
                agency.getPropertiesWithBedrooms(2, 5));
        System.out.println("Properties of type 'residence': " +
                agency.getPropertiesOfType("residence"));
    }
}
