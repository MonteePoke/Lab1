/**
 * SmallInteger class
 * Working range: -10 000..10 000
 * @author Montee Poke
 */
public class SmallInteger
{
    private int value;

    /**
     * Checks if V is in SmallInteger range
     * @param v value to check
     * @throws  IllegalArgumentException if value is not in range
     */
    private void clamp(int v)
    {
        if (Math.abs(v)>10000)
        {
            throw new IllegalArgumentException("Out of range");
        }
    }

    /**
     * Print out operation being conducted
     * @param sign operation sign
     * @param SI second SmallInteger
     * @param result resulting SmallInteger
     */
    private void print_operation(String sign, SmallInteger SI, SmallInteger result)
    {
        System.out.println(value+sign+SI.getValue()+"="+result.getValue());
    }

    /**
     * Returns value
     * @return value
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Sets value
     * @param v value to set
     */
    public void setValue(int v)
    {
        value = v;
        clamp(value);
    }

    /**
     * Empty constructor
     */
    SmallInteger()
    {
        value = 0;
    }

    /**
     * Constructor with value setter
     * @param v value to set
     */
    SmallInteger(int v)
    {
        value = v;
        clamp(value);
    }

    /**
     * Sums this SmallInteger with another
     * @param SI second SmallInteger
     * @return new SmallInteger object
     */
    public SmallInteger summarize(SmallInteger SI)
    {
        SmallInteger Result = new SmallInteger(value+SI.getValue());
        print_operation("+",SI,Result);
        return Result;
    }

    /**
     * Subs this SmallInteger with another
     * @param SI second SmallInteger
     * @return new SmallInteger object
     */
    public SmallInteger subtract(SmallInteger SI)
    {
        SmallInteger Result = new SmallInteger(value-SI.getValue());
        print_operation("-",SI,Result);
        return Result;
    }

    /**
     * Multiplies this SmallInteger with another
     * @param SI second SmallInteger
     * @return new SmallInteger object
     */
    public SmallInteger multiply(SmallInteger SI)
    {
        SmallInteger Result = new SmallInteger(value*SI.getValue());
        print_operation("*",SI,Result);
        return Result;
    }

    /**
     * Divides this SmallInteger by another
     * @param SI second SmallInteger
     * @return new SmallInteger object
     */
    public SmallInteger divide(SmallInteger SI)
    {
        SmallInteger Result = new SmallInteger(value/SI.getValue());
        print_operation("/",SI,Result);
        return Result;
    }
}
