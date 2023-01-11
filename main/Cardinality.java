import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class Cardinality {
 
    public static void main(String[] args) {
 
        List<Double> listOne = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        List<Double> listTwo = new ArrayList<>(Arrays.asList(10.0, 11.0, 12.0, 13.0, 14.0, 15.0));
 
        SetOfNumbers setOne = new SetOfNumbers(listOne); 
        SetOfNumbers setTwo = new SetOfNumbers(6); 
 
        setTwo.setNumbers(listTwo); 
 
        System.out.println("Первое множество: ");
        System.out.println(setOne.toString());  
 
        System.out.println("Второе множество: ");
        System.out.println(setTwo.toString()); 
 
        setOne.joinSet(setTwo); 
 
        System.out.println("Первое множество после объединения со вторым: ");
        System.out.println(setOne.toString());
 
        Double numberToCheck = 99.0;
        if (setOne.isNumberBelongToSet(numberToCheck)) { 
            System.out.println(numberToCheck + " принадлежит множеству.");
        } else {
            System.out.println(numberToCheck + " не принадлежит множеству.");
        }
 
    }
 
    private static class SetOfNumbers {
 
        private int cardinality; 
        private List<Double> numbers; 
 
        
        SetOfNumbers(int cardinality) {
            this.cardinality = cardinality;
            this.numbers = new ArrayList<>(cardinality);
        }


 
        
        SetOfNumbers(List<Double> numbers) {
            this.numbers = numbers;
            calculateCardinality();
        }
 
   
        List<Double> getNumbers() {
            return numbers;
        }
 
        
        void setNumbers(List<Double> numbers) {
            this.numbers = numbers;
            calculateCardinality();
        }
 
        
        private void calculateCardinality() {
            this.cardinality = numbers.size();
        }
 
        
        public int getCardinality() {
            return cardinality;
        }
 
    
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
 

        boolean isNumberBelongToSet(Double number) {
            return numbers.contains(number);
        }

        void joinSet(SetOfNumbers newSet) {
            this.numbers.addAll(newSet.getNumbers());
            calculateCardinality();
        }
 
    }
 
}