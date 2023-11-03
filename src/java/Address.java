/**
 * @author Senzo NKosi
 * @version 1.0
 */
/**
 * A class representing an address with various components such as unit number,
 * street number, street name, postal code, and city.
 */
public class Address {
    private final String unitNumber;
    private final int streetNumber;
    private final String streetName;
    private final String postalCode;
    private final String city;
    /**
     * Constructs an address object with the provided components.
     *
     * @param unitNumber The unit number (can be null or up to 4 characters).
     * @param streetNumber The street number (between 0 and 999999).
     * @param streetName The name of the street (up to 20 characters, cannot be null).
     * @param postalCode The postal code (5 or 6 characters, cannot be null).
     * @param city The city name (up to 30 characters, cannot be null).
     * @throws IllegalArgumentException If any of the input values are invalid.
     * @throws NullPointerException If streetName, postalCode, or city is null.
     */
    public Address(final String unitNumber,
                   final int streetNumber,
                   final String streetName,
                   final String postalCode,
                   final String city) throws IllegalArgumentException {
        if (unitNumber != null &&
                (unitNumber.isEmpty() || unitNumber.length() > 4)) {
            throw new IllegalArgumentException("Invalid unit number: "+unitNumber);
        }
        if (streetNumber < 0 || streetNumber > 999999) {
            throw new IllegalArgumentException("Invalid street number: "+streetNumber);
        }
        if (streetName==null){
            throw new NullPointerException("Invalid street name: null");
        }
        if (streetName.isEmpty() || streetName.length() > 20) {
            throw new IllegalArgumentException("Invalid street name: "+streetName);
        }
        if (postalCode==null){
            throw new NullPointerException("Invalid postal code: null");
        }
        if (postalCode.length() != 5 && postalCode.length() != 6) {
            throw new IllegalArgumentException("Invalid postal code: "+postalCode);
        }
        if (city==null){
            throw new NullPointerException("Invalid city: null");
        }
        if (city.isEmpty() || city.length() > 30) {
            throw new IllegalArgumentException("Invalid city: "+city);
        }
        this.unitNumber = unitNumber;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
    }
    /**
     * Gets the unit number of the address.
     * @return The unit number or null if not applicable.
     */
    public String getUnitNumber() {
        return unitNumber;
    }

    /**
     * Gets the street number of the address.
     * @return The street number.
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * Gets the name of the street in the address.
     * @return The street name.
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Gets the postal code of the address.
     * @return The postal code.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Gets the city name of the address.
     * @return The city name.
     */
    public String getCity() {
        return city;
    }

}
