package uni.master.entity;

public class ColorRGB {
    public final int r, g, b;

    public ColorRGB(int color) {
        this.r = (color & 0x00ff0000) >> 16;
        this.g = (color & 0x0000ff00) >> 8;
        this.b = color & 0x000000ff;
    }

    @Override
    public String toString() {
        return "ColorRGB{" +
                "r=" + r +
                ", g=" + g +
                ", b=" + b +
                '}';
    }
}
