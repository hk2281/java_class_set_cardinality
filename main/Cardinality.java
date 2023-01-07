import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class Cardinality {
 
    public static void main(String[] args) {
 
        List<Double> listOne = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        List<Double> listTwo = new ArrayList<>(Arrays.asList(10.0, 11.0, 12.0, 13.0, 14.0, 15.0));
 
        SetOfNumbers setOne = new SetOfNumbers(listOne); // Инициализируем множество значениями
        SetOfNumbers setTwo = new SetOfNumbers(6); // Инициализируем множество без первоначальных значений
 
        setTwo.setNumbers(listTwo); // Присваиваем значения множеству
 
        System.out.println("Первое множество: ");
        System.out.println(setOne.toString()); // Выводим множество на печать
 
        System.out.println("Второе множество: ");
        System.out.println(setTwo.toString()); // Выводим множество на печать
 
        setOne.joinSet(setTwo); // Объединяем множества
 
        System.out.println("Первое множество после объединения со вторым: ");
        System.out.println(setOne.toString()); // Выводим множество на печать
 
        Double numberToCheck = 99.0;
        if (setOne.isNumberBelongToSet(numberToCheck)) { // Проверяем, принадлежит ли число множеству
            System.out.println(numberToCheck + " принадлежит множеству.");
        } else {
            System.out.println(numberToCheck + " не принадлежит множеству.");
        }
 
    }
 
    private static class SetOfNumbers {
 
        private int cardinality; // Мощность множества
        private List<Double> numbers; // Значения множества
 
        // Конструктор инициализируется только значением мощности множества, без инициализации значениями
        SetOfNumbers(int cardinality) {
            this.cardinality = cardinality;
            this.numbers = new ArrayList<>(cardinality);
        }
 
        // Конструктор инициализируется с заданными начальными значениями
        SetOfNumbers(List<Double> numbers) {
            this.numbers = numbers;
            calculateCardinality();
        }
 
        // Получить все значения множества
        List<Double> getNumbers() {
            return numbers;
        }
 
        // Задать значения множества
        void setNumbers(List<Double> numbers) {
            this.numbers = numbers;
            calculateCardinality();
        }
 
        // Пересчитать мощность множества при изменении данных
        private void calculateCardinality() {
            this.cardinality = numbers.size();
        }
 
        // Получить мощность множества
        public int getCardinality() {
            return cardinality;
        }
 
        // Получить множество в виде строки
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Мощность множества: ")
                    .append(cardinality)
                    .append(". ")
                    .append("Значения: {");
            for (int i = 0; i < numbers.size(); i++) {
                sb.append(String.valueOf(numbers.get(i)));
                if (i != numbers.size() - 1) {
                    sb.append(", ");
                } else {
                    sb.append("}");
                }
            }
            return sb.toString();
        }
 
        // Проверить, принадлежит ли значение множеству
        boolean isNumberBelongToSet(Double number) {
            return numbers.contains(number);
        }
 
        // Объединить передаваемое множество с текущим
        void joinSet(SetOfNumbers newSet) {
            this.numbers.addAll(newSet.getNumbers());
            calculateCardinality();
        }
 
    }
 
}