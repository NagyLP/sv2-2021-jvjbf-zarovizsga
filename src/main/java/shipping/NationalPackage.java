package shipping;

public class NationalPackage implements Transportable {

    private static final int INLAND_TRANS_PRICE = 1000;
    private static final int BREAKABLE_PRICEiNCREASER = 2;

    private final int weight;
    private final boolean breakable;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    @Override
    public int calculateShippingPrice() {
        if (breakable) {
            return INLAND_TRANS_PRICE * BREAKABLE_PRICEiNCREASER;

        } else {
            return INLAND_TRANS_PRICE;
        }
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }
}
