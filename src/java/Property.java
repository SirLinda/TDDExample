/**
 * @author Senzo NKosi
 * @version 1.0
 */
/**
 * A class representing a real estate property with various attributes including price, address, bedrooms,
 * swimming pool presence, type, and property ID.
 */
public class Property {
    private Double priceInUsd;
    private final Address address;
    private final int numberOfBedrooms;
    private final boolean hasSwimmingPool;
    private final String type;
    private final String propertyId;
    private String propertyName;

    /**
     * Constructs a Property object with the provided attributes.
     *
     * @param priceInUsd The price of the property in USD (must be greater than 0).
     * @param address The address of the property (cannot be null).
     * @param numberOfBedrooms The number of bedrooms in the property (between 1 and 20).
     * @param hasSwimmingPool Whether the property has a swimming pool.
     * @param type The type of the property (must be "residence", "commercial", or "retail", case-insensitive).
     * @param propertyId The ID of the property (up to 6 characters, cannot be null or empty).
     * @throws IllegalArgumentException If any of the input values are invalid.
     * @throws NullPointerException If address or type is null.
     */
    public Property(final Double priceInUsd, final Address address,final int numberOfBedrooms, final boolean hasSwimmingPool,final String type, final String propertyId) {
        if (priceInUsd <= 0) {
            throw new IllegalArgumentException("Invalid price: "+ priceInUsd);
        }
        if (numberOfBedrooms < 1 || numberOfBedrooms > 20) {
            throw new IllegalArgumentException("Invalid number of bedrooms: "+numberOfBedrooms);
        }
        if(type==null){
            throw new NullPointerException("Invalid property type: null");
        }
        if (!type.equalsIgnoreCase("residence")
                && !type.equalsIgnoreCase("commercial")
                && !type.equalsIgnoreCase("retail")) {
            throw new IllegalArgumentException("Invalid property type: "+type);
        }
        if(propertyId==null){
            throw new NullPointerException("Invalid property id: null");
        }
        if (propertyId.length() > 6 || propertyId.isEmpty()) {
            throw new IllegalArgumentException("Invalid property id: "+propertyId);
        }
        if(address==null){
            throw new NullPointerException("Invalid address: null");
        }

        this.priceInUsd = priceInUsd;
        this.address = address;
        this.numberOfBedrooms = numberOfBedrooms;
        this.hasSwimmingPool = hasSwimmingPool;
        this.type = type;
        this.propertyId = propertyId;
    }
    /**
     * Sets the price of the property in USD.
     * @param priceInUsd The price to set.
     */
    public void setPriceUsd(final Double priceInUsd){
        this.priceInUsd = priceInUsd;
    }

    /**
     * Gets the price of the property in USD.
     * @return The price of the property.
     */
    public Double getPriceUsd() {
        return priceInUsd;
    }

    /**
     * Sets the price of the property in USD.
     * @param priceInUsd The price to set.
     */
    public void setPriceInUsd(final Double priceInUsd){
        this.priceInUsd = priceInUsd;
    }

    /**
     * Gets the address of the property.
     * @return The address of the property.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Gets the number of bedrooms in the property.
     * @return The number of bedrooms.
     */
    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    /**
     * Checks if the property has a swimming pool.
     * @return True if the property has a swimming pool, false otherwise.
     */
    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }

    /**
     * Gets the type of the property.
     * @return The type of the property.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the ID of the property.
     * @return The ID of the property.
     */
    public String getPropertyId() {
        return propertyId;
    }
}