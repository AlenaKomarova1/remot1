import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс, содержащий методы для работы с комплексными числами
 */
public class ComplexCalculator {
    private static final Logger logger = Logger.getLogger(ComplexCalculator.class.getName());

    /**
     * Метод для сложения двух комплексных чисел
     * @param a Первое комплексное число
     * @param b Второе комплексное число
     * @return Результат сложения
     */
    public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        double realPart = a.getRealPart() + b.getRealPart();
        double imaginaryPart = a.getImaginaryPart() + b.getImaginaryPart();
        return new ComplexNumber(realPart, imaginaryPart);
    }

    /**
     * Метод для умножения двух комплексных чисел
     * @param a Первое комплексное число
     * @param b Второе комплексное число
     * @return Результат умножения
     */
    public static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        double realPart = a.getRealPart() * b.getRealPart() - a.getImaginaryPart() * b.getImaginaryPart();
        double imaginaryPart = a.getRealPart() * b.getImaginaryPart() + a.getImaginaryPart() * b.getRealPart();
        return new ComplexNumber(realPart, imaginaryPart);
    }

    /**
     * Метод для деления двух комплексных чисел
     * @param a Делимое комплексное число
     * @param b Делитель комплексное число
     * @return Результат деления
     */
    public static ComplexNumber divide(ComplexNumber a, ComplexNumber b) {
        double divisor = b.getRealPart() * b.getRealPart() + b.getImaginaryPart() * b.getImaginaryPart();
        if (divisor == 0) {
            logger.log(Level.WARNING, "Division by zero");
            return null;
        }
        double realPart = (a.getRealPart() * b.getRealPart() + a.getImaginaryPart() * b.getImaginaryPart()) / divisor;
        double imaginaryPart = (a.getImaginaryPart() * b.getRealPart() - a.getRealPart() * b.getImaginaryPart()) / divisor;
        return new ComplexNumber(realPart, imaginaryPart);
    }
}

/**
 * Класс, представляющий комплексное число
 */
class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    /**
     * Конструктор класса ComplexNumber
     * @param realPart Вещественная часть комплексного числа
     * @param imaginaryPart Мнимая часть комплексного числа
     */
    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Метод для получения вещественной части комплексного числа
     * @return Вещественная часть комплексного числа
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     * Метод для получения мнимой части комплексного числа
     * @return Мнимая часть комплексного числа
     */
    public double getImaginaryPart() {
        return imaginaryPart;
    }
}
