public class Main {
    private static final String VECTOR_CIRCLE = "VECTOR circle radius=2";
    private static final String RASTER_CIRCLE = "RASTER circle radius=2 bitmap=5x5";
    private static final String VECTOR_SQUARE = "VECTOR square side=3";
    private static final String RASTER_SQUARE = "RASTER square side=3 bitmap=3x3";
    private static final String ASCII_CIRCLE = "ASCII circle radius=2 art=(o)";
    private static final String ASCII_SQUARE = "ASCII square side=3 art=[###]";

    private static int passed = 0;
    private static int total = 0;

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Usage: java -cp out Main --demo");
        }
    }

    private static void runDemo() {
        runCombinationChecks();
        checkRuntimeSwitch();
        runExtensionChecks();
        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }

    private static void runExtensionChecks() {
        checkShape("T6", new Circle("C-1", 2, new AsciiRenderer()), ASCII_CIRCLE);
        checkShape("T7", new Square("S-1", 3, new AsciiRenderer()), ASCII_SQUARE);
    }

    private static void checkRuntimeSwitch() {
        Circle original = new Circle("C-5", 2, new VectorRenderer());
        String idBefore = original.getId();
        int radiusBefore = original.getRadius();

        String before = original.execute();
        Shape afterSwitch = switchRenderer(original, new RasterRenderer());
        String after = afterSwitch.execute();

        boolean sameObject = (original == afterSwitch);
        boolean stateUnchanged = idBefore.equals(afterSwitch.getId())
                && radiusBefore == original.getRadius();
        boolean resultsOk = before.equals(VECTOR_CIRCLE) && after.equals(RASTER_CIRCLE);

        String details = "sameObject=" + sameObject + " | stateUnchanged=" + stateUnchanged
                + "\n   before=" + before + " | after=" + after;
        String expected = "before=" + VECTOR_CIRCLE + " | after=" + RASTER_CIRCLE;
        report("T5", sameObject && stateUnchanged && resultsOk, details, expected);
    }

    private static void runCombinationChecks() {
        checkShape("T1", new Circle("C-1", 2, new VectorRenderer()), VECTOR_CIRCLE);
        checkShape("T2", new Circle("C-1", 2, new RasterRenderer()), RASTER_CIRCLE);
        checkShape("T3", new Square("S-1", 3, new VectorRenderer()), VECTOR_SQUARE);
        checkShape("T4", new Square("S-1", 3, new RasterRenderer()), RASTER_SQUARE);
    }

    private static Shape switchRenderer(Shape shape, Renderer newRenderer) {
        shape.setImplementation(newRenderer);
        return shape;
    }

    private static void checkShape(String id, Shape shape, String expected) {
        String actual = shape.execute();
        String classes = shape.getClass().getSimpleName() + " + "
                + shape.getImplementation().getClass().getSimpleName();
        report(id, actual.equals(expected), classes + " | result=" + actual, expected);
    }

    private static void report(String id, boolean ok, String details, String expected) {
        total++;
        if (ok) {
            passed++;
        }
        String line = id + (ok ? " PASS" : " FAIL") + " | " + details;
        if (!ok) {
            line += " | expected=" + expected;
        }
        System.out.println(line);
    }
}