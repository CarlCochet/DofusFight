package core;

public class Extensions<T> {

    public static int getPercentageOf(int value, int percentage){
        return (int)((double)value * ((double)percentage / (double)100));
    }

    public static long getPercentageOf(long value, long percentage){
        return (long)((double)value * ((double)percentage / (double)100));
    }

    public static int percentage(int current, int length){
        return (int)(((double)current / (double)length) * (double)100);
    }

    public static long percentage(long current, long length){
        return (long)(((double)current / (double)length) * (double)100);
    }

}
