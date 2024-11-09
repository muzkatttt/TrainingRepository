package streamApi;


public class Mycalc {
    //который будет вычислять площадь и периметр фигуры.


    }
//    public static String processLine(String line) {
//            StringBuilder sb = new StringBuilder();
//            for (char c : line.toCharArray()) {
//                if (!Character.isDigit(c)) {
//                    sb.append(c);
//                }
//            }
//            return sb.toString();
//        }
//    public static String reverseString(String str) {
//        char[] charArray = str.toCharArray();
//        int i = 0;
//        int j = str.length() - 1;
//
//        while (i < j) {
//            char temp = charArray[i];
//            charArray[i] = charArray[j];
//            charArray[j] = temp;
//            i++;
//            j--;
//        }
//
//        return new String(charArray);
//
//    }
//    public void calculate(String input) {
//        Scanner scanner = new Scanner(System.in);
//        String[] input2 = scanner.nextLine().split(" ");
//
//        String figureType = input2[0];
//        double measurement = input2.length > 1 ? Double.parseDouble(input2[1]) : 1.0;
//
//        switch (figureType) {
//            case "круг":
//                calculateCircle(measurement);
//                break;
//            case "квадрат":
//                calculateSquare(measurement);
//                break;
//            default:
//                System.out.println("Неправильный тип фигуры!");
//        }
//    }
//
//    private static void calculateCircle(double radius) {
//        double area = Math.PI * radius * radius;
//        double perimeter = 2 * Math.PI * radius;
//        System.out.printf("%.2f %.2f\n", area, perimeter);
//    }
//
//    private static void calculateSquare(double side) {
//        double area = side * side;
//        double perimeter = 4 * side;
//        System.out.printf("%.2f %.2f\n", area, perimeter);
//    }
//                    input.split(" ");
//
//                    if (input.equals("круг")) {
//                        double pl = Math.PI * measurement * measurement;
//                        double per = 2 * Math.PI * measurement;
//
//                        return Math.PI * measurement * measurement;
//                    } else if (type.equals("квадрат")) {
//                        return measurement * measurement;
//                    } else {
//                        return 0.0;
//                    }
//
//                    if (type.equals("круг")) {
//                        return 2 * Math.PI * measurement;
//                    } else if (type.equals("квадрат")) {
//                        return 4 * measurement;
//                    } else {
//                        return 0.0;
//                    }
//                }
//                    // Ваш код
//                    return "0.00 0.00";
//                }

