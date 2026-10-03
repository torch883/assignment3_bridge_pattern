public class RasterRenderer implements Renderer {
    @Override
    public String drawCircle(int radius) {
        int diameter = radius * 2 + 1;
        return "RASTER circle radius=" + radius + " bitmap=" + diameter + "x" + diameter;
    }

    @Override
    public String drawSquare(int side) {
        return "RASTER square side=" + side + " bitmap=" + side + "x" + side;
    }
}