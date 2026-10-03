# Assignment 3 | Bridge Pattern
- Name: Arman Mukashev
- Group: SE-2530
- Topic: A (Drawing)
- Repository: https://github.com/torch883/assignment3_bridge_pattern
- Base commit (I1/I2 version): a506bca31e6db68fdced235f11ad108b649fc712

## Role map
| Role | Class | Path |
|------|-------|------|
| Abstraction | Shape | src/Shape.java |
| A1 | Circle | src/Circle.java |
| A2 | Square | src/Square.java |
| Implementor | Renderer | src/Renderer.java |
| I1 | VectorRenderer | src/VectorRenderer.java |
| I2 | RasterRenderer | src/RasterRenderer.java |
| I3 | AsciiRenderer | src/AsciiRenderer.java |
| Client | Main | src/Main.java |

## Where to look
- Bridge field: `Shape.renderer` (Shape.java)
- `execute()`: Shape.java (abstract), Circle.java, Square.java
- `setImplementation(...)`: Shape.java
- T5: `Main.checkRuntimeSwitch()` (Main.java)

## Run
```
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

## Expected results
| Check | Expected result |
|---|---|
| T1 | VECTOR circle radius=2 |
| T2 | RASTER circle radius=2 bitmap=5x5 |
| T3 | VECTOR square side=3 |
| T4 | RASTER square side=3 bitmap=3x3 |
| T5 | sameObject=true, stateUnchanged=true, before=VECTOR..., after=RASTER... |
| T6 | ASCII circle radius=2 art=(o) |
| T7 | ASCII square side=3 art=[###] |
| Summary | SUMMARY: 7/7 PASS |