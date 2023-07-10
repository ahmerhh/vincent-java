# Vincenty Distance Calculator

This Java program calculates the accurate distance between two points on the Earth's surface using the Vincenty formula. The Vincenty formula takes into account the Earth's oblate spheroid shape, providing more accurate results compared to the simple Haversine formula.

## Usage

1. Clone the repository or download the source code files.
2. Open the project in your Java development environment.
3. Run the `VincentyDistance.java` file.

The program will prompt you to enter the latitude and longitude values for two points. After providing the inputs, it will calculate and display the distance between the two points in kilometers.

## Requirements

- Java Development Kit (JDK) 8 or above.

## Vincenty Formula

The Vincenty formula is an algorithm used to calculate the distance between two points on an oblate spheroid. It takes into account the flattening of the Earth and provides more accurate results compared to the simpler Haversine formula. The formula involves iterative calculations to converge on the accurate distance.

## Limitations

- The program assumes input coordinates provided in decimal degrees.
- Proper validation and range checking should be implemented to handle invalid or out-of-range input values.

## References

- [Vincenty formula](https://en.wikipedia.org/wiki/Vincenty%27s_formulae)
- [Geodesy: Vincenty's formulae](https://www.movable-type.co.uk/scripts/latlong-vincenty.html)

## License

This project is licensed under the [MIT License](LICENSE).

