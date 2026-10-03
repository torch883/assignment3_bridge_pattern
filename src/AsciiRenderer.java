public class AsciiRenderer implements Renderer {
    @Override
    public String drawCircle(int radius) {
        return "ASCII circle radius=" + radius + " art=(o)";
    }

    @Override
    public String drawSquare(int side) {
        return "ASCII square side=" + side + " art=[" + "#".repeat(side) + "]";
    }
}