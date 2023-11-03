/**
 * @author Senzo NKosi
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.HashMap;



/**
 * A class representing a real estate agency that manages properties.
 */

public class Agency {
    private final String name;
    private final HashMap<String, Property> properties;
    private static final Double MIN_VALUE = 0.00;

    public Agency(final String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty() || name.length() > 30) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.properties = new HashMap<>();
    }
    /**
     * Gets the name of the agency.
     * @return The name of the agency.
     */
    public String getName() {
        return name;
    }
    /**
     * Adds a property to the agency's list of managed properties.
     * @param property The property to add (must not be null).
     * @throws IllegalArgumentException If the provided property is null.
     */
    public void addProperty(final Property property) throws IllegalArgumentException{
        if (property == null) {
            throw new IllegalArgumentException();
        }
        properties.put(property.getPropertyId(), property);
    }
    /**
     * Removes a property from the agency's list of managed properties.
     * @param propertyId The ID of the property to remove.
     */
    public void removeProperty(final String propertyId){

        properties.remove(propertyId);
    }
    /**
     * Gets a property by its ID.
     * @param propertyId The ID of the property to retrieve.
     * @return The property with the given ID, or null if not found.
     */
    public Property getProperty(final String propertyId) {

        return properties.get(propertyId);
    }
    /**
     * Calculates the total value of all managed properties.
     * @return The total value of all properties in USD.
     */
    public Double getTotalPropertyValues(){
        Double total = MIN_VALUE;
        for(Property property : properties.values()){
            total = total + property.getPriceUsd();
        }
        return total;
    }
    /**
     * Retrieves properties with swimming pools.
     * @return A list of properties with swimming pools, or null if none are found.
     */
    public ArrayList<Property> getPropertiesWithPools(){
        ArrayList<Property> propertiesWithPools = new ArrayList<>();
        for (Property property : properties.values()) {
            if (property.hasSwimmingPool()) {
                propertiesWithPools.add(property);
            }
        }
        if(propertiesWithPools.isEmpty()){
            return null;
        }
        else {
            return propertiesWithPools;
        }
    }
    /**
     * Retrieves properties with prices within a specified range.
     * @param minUsd The minimum price in USD.
     * @param maxUsd The maximum price in USD.
     * @return A list of properties within the specified price range, or null if none are found.
     */
    public ArrayList<Property> getPropertiesBetween(final Double minUsd, final Double maxUsd){
        ArrayList<Property> propertiesBetween = new ArrayList<>();
        for (Property property : properties.values()) {
            if (property.getPriceUsd()>=minUsd && property.getPriceUsd()<=maxUsd) {
                propertiesBetween.add(property);
            }
        }
        if(propertiesBetween.isEmpty()){
            return null;
        }
        else {
            return propertiesBetween;
        }
    }
    /**
     * Retrieves properties located on a specific street.
     * @param streetName The name of the street.
     * @return A list of properties on the specified street, or null if none are found.
     */
    public ArrayList<Address> getPropertiesOn(final String streetName){
        ArrayList<Address> propertiesOn = new ArrayList<>();
        for (Property property : properties.values()) {
            Address address = property.getAddress();
            if (address.getStreetName().equals(streetName)) {
                propertiesOn.add(address);
            }
        }
        if(propertiesOn.isEmpty()){
            return null;
        }
        else {
            return propertiesOn;
        }
    }
    /**
     * Retrieves properties with a specific number of bedrooms.
     * @param minBedrooms The minimum number of bedrooms.
     * @param maxBedrooms The maximum number of bedrooms.
     * @return A map of properties with the specified number of bedrooms, or null if none are found.
     */
    public HashMap<String, Property> getPropertiesWithBedrooms(final int minBedrooms, final int maxBedrooms){
        HashMap<String,Property> propertiesBetween = new HashMap<>();
        for (Property property : properties.values()) {
            int bedrooms;
            bedrooms= property.getNumberOfBedrooms();
            if (bedrooms>=minBedrooms && bedrooms<=maxBedrooms) {
                propertiesBetween.put(property.getPropertyId(),property);
            }
        }
        if(propertiesBetween.isEmpty()){
            return null;
        }
        else {
            return propertiesBetween;
        }
    }
    /**
     * Retrieves properties of a specific type.
     * @param propertyType The type of property (case-insensitive).
     * @return A list of properties of the specified type, or null if none are found.
     */
    public ArrayList<String> getPropertiesOfType(final String propertyType){
        ArrayList<String> propertiesOfType= new ArrayList<>();
        for (Property property: properties.values()){
            if (property.getType().equals(propertyType)){
                propertiesOfType.add(formatPropertyString(property));
            }
        }
        if(propertiesOfType.isEmpty()){
            return null;
        }
        else {
            return propertiesOfType;
        }
    }
    private String formatPropertyString(final Property property) {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(property.getType().toUpperCase()).append("\n");
        sb.append(property.getPropertyId()).append(": ");
        sb.append(property.getAddress().getUnitNumber()).append(" at ");
        sb.append(property.getAddress().getStreetNumber()).append(" ");
        sb.append(property.getAddress().getStreetName()).append(" ");
        sb.append(property.getAddress().getPostalCode()).append(" in ");
        sb.append(property.getAddress().getCity()).append(" (");
        sb.append(property.getNumberOfBedrooms()).append(" bedroom");
        if (property.getNumberOfBedrooms() > 1) {
            sb.append("s");
        }
        if (property.hasSwimmingPool()) {
            sb.append(" plus pool");
        }
        sb.append("): $");
        sb.append(property.getPriceUsd());
        sb.append(".");
        return sb.toString();
    }
}
