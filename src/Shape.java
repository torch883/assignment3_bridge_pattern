public abstract class Shape {
    private final String id;
    private Renderer renderer;

    public Shape(String id, Renderer renderer) {
        this.id = id;
        setImplementation(renderer);
    }

    public String getId() {
        return id;
    }

    public Renderer getImplementation() {
        return renderer;
    }

    public void setImplementation(Renderer renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("renderer must not be null");
        }
        this.renderer = renderer;
    }

    public abstract String execute();
}