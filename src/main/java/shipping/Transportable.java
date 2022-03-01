package shipping;

public interface Transportable {

//    private final String DESTINATION_COUNTRY = "Hungary";

    int getWeight();
    boolean isBreakable();
    int calculateShippingPrice();

    default String getDestinationCountry() {
        return "Hungary";
//    return DESTINATION_COUNTRY;
    }
}
