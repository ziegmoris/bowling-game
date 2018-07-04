public class Roll {
    private String symbol;

    private Integer value;

    Integer getValue() {
        return value;
    }

    void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    void setValue(){
        this.value = Value.of(symbol);
    }

    enum Value {
        STRIKE(10),
        GUTTER(0),
        SPARE(10);

        private final Integer value;

        Value(Integer v) {
            this.value = v;
        }

        static int of(String value) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                return Value.valueOf(value).value;
            }
        }

    }
}
