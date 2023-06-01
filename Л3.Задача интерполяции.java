class PolynomialTerm {

  // Класс для хранения одного элемента полинома

  double coefficient; // Коэффициент элемента полинома
  int degree; // Степень элемента полинома
}

class Polynomial {

  // Класс для хранения полинома

  LinkedList<PolynomialTerm> terms; // Связный список элементов полинома

  // Сложение полиномов
  // @param other - полином для сложения с текущим полиномом
  Polynomial add(Polynomial other) {
    // 1. Создать новый объект Polynomial для результата сложения
    // 2. Обойти элементы текущего полинома и полинома other
    // 3. Сложить коэффициенты элементов с одинаковыми степенями
    // 4. Добавить полученный элемент в результат, если коэффициент не равен нулю
    // 5. Вернуть результат
  }

  // Умножение полиномов
  // @param other - полином для умножения на текущий полином
  Polynomial multiply(Polynomial other) {
    // 1. Создать новый объект Polynomial для результата умножения
    // 2. Обойти элементы текущего полинома и полинома other
    // 3. Умножить коэффициенты и сложить степени элементов
    // 4. Добавить полученный элемент в результат
    // 5. Вернуть результат с учётом свёртки одинаковых степеней и удаления нулевых коэффициентов
  }

  // Умножение полинома на вещественное число
  // @param scalar - вещественное число для умножения на текущий полином
  Polynomial multiplyByScalar(double scalar) {
    // 1. Создать новый объект Polynomial для результата умножения
    // 2. Обойти элементы текущего полинома
    // 3. Умножить коэффициенты элементов на scalar
    // 4. Добавить полученный элемент в результат
    // 5. Вернуть результат
  }

  // Вычисление значения полинома в точке по правилу Горнера
  // @param x - точка, в которой вычисляется значение полинома
  double evaluate(double x) {
    // 1. Инициализировать переменную result нулём
    // 2. Обойти элементы полинома в обратном порядке
    // 3. Вычислить значение элемента полинома в точке x
    // 4. Добавить значение элемента к result
    // 5. Вернуть result
  }

  // Вывод полинома на экран
  void print() {
    // 1. Обойти элементы полинома
    // 2. Вывести на экран коэффициент и степень каждого элемента с учётом знака и формата вывода
  }
}

class Grid {

  // Класс для хранения узлов сетки и значений сеточной функции

  double[] nodes; // Массив узлов сетки
  double[] values; // Массив значений сеточной функции
}

class LagrangePolynomial {

  // Класс для интерполяционного полинома Лагранжа

  Polynomial polynomial; // Объект класса Polynomial для хранения полинома

  // Конструктор класса LagrangePolynomial, принимающий объект класса Grid
  // @param grid - объект класса Grid с узлами сетки и значениями сеточной функции
  LagrangePolynomial(Grid grid) {
    // 1. Создать новый объект Polynomial для результата
    // 2. Используя узлы сетки и значения сеточной функции, построить полином Лагранжа
    // 3. Сохранить полученный полином в поле polynomial
  }

  // Метод для вывода полинома на экран
  void print() {
    // 1. Вызвать метод print() объекта Polynomial для вывода полинома на экран
  }
}

class Interpolator {

  // Класс с методом main() и функцией f(x) для вычисления значения узла сетки

  public static void main(String[] args) {
    // 1. Задать отрезок [a; b] и количество точек
    // 2. Создать объект класса Grid с узлами сетки и значениями сеточной функции
    // 3. Создать объект класса LagrangePolynomial, используя объект Grid для построения полинома
    // 4. Вывести полином на экран в экспоненциальном виде с 6 знаками после десятичной точки
    // 5. Вызвать метод, выводящий результаты интерполяции в табличной форме с форматированным выводом
  }

  public static double f(double x) {
    // 1. Реализация функции для вычисления значения узла сетки в точке x
  }
}

class Table {

  // Класс для вывода результатов интерполяции в табличной форме

  // Метод для вывода результатов интерполяции
  // @param lagrangePolynomial - объект класса LagrangePolynomial с интерполяционным полиномом
  // @param grid - объект класса Grid с узлами сетки и значениями сеточной функции
  // @param a - начало интервала
  // @param b - конец интервала
  // @param points - количество точек
  void printResults(
    LagrangePolynomial lagrangePolynomial,
    Grid grid,
    double a,
    double b,
    int points
  ) {
    // 1. Вычислить шаг между точками
    // 2. Вывести заголовки столбцов таблицы
    // 3. Обойти точки интервала [a; b] с заданным шагом
    // 4. Вывести значение x, значение интерполяционного полинома и значение исходной функции f(x) для каждой точки
  }
}

class Main {

  // Главный класс с методом main()

  public static void main(String[] args) {
    // 1. Задать отрезок [a; b] и количество точек
    // 2. Создать объект класса Grid с узлами сетки и значениями сеточной функции
    // 3. Создать объект класса LagrangePolynomial, используя объект Grid для построения полинома
    // 4. Вывести полином на экран в экспоненциальном виде с 6 знаками после десятичной точки
    // 5. Создать объект класса Table для вывода результатов интерполяции
    // 6. Вызвать метод printResults() объекта класса Table с параметрами: объектом класса LagrangePolynomial, объектом класса Grid, a, b и количество точек
  }

  public static double f(double x) {
    // 1. Реализация функции для вычисления значения узла сетки в точке x
  }
}
