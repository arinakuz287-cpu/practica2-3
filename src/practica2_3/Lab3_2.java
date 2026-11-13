package practica2_3;

public class Lab3_2 {
    public Lab3_2() {
    }

    public static void main(String[] args) {
        System.out.println("Задание 1");
        task1();
        System.out.println("\nЗадание 2");
        task2();
        System.out.println("\nЗадание 3");
        task3();
        System.out.println("\nЗадание 4");
        task4();
        System.out.println("\nStopWatch");
        taskStopWatch();
    }

    static void task1() {
        F f = new F();
        System.out.println(f.i);
        System.out.println(Lab3_2.F.s);
        f.method();
        Lab3_2.F.statMethod();
        System.out.println(Lab3_2.F.s);
        Lab3_2.F.statMethod();
        System.out.println("Все допустимые вызовы выполнены.");
    }

    static void task2() {
        System.out.println("5! = " + Lab3_2.TestStatic.factorial(5));
    }

    static void task3() {
        C c = new C();
        c.method1();
    }

    static void task4() {
        Circle[] circles = new Circle[5];

        for(int i = 0; i < circles.length; ++i) {
            circles[i] = new Circle((double)i + 1.0);
        }

        System.out.println("Создано кругов: " + Lab3_2.Circle.numberOfObjects);
        Circle maxCircle = circles[0];

        for(int i = 1; i < circles.length; ++i) {
            if (circles[i].getArea() > maxCircle.getArea()) {
                maxCircle = circles[i];
            }
        }

        double var10001 = maxCircle.radius;
        System.out.println("Круг с макс. площадью: радиус = " + var10001 + ", площадь = " + String.format("%.2f", maxCircle.getArea()));
    }

    static void taskStopWatch() {
        int[] arr = new int[100000];

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = (int)(Math.random() * 100000.0);
        }

        StopWatch sw = new StopWatch();
        sw.start();

        for(int i = 0; i < arr.length - 1; ++i) {
            int minIndex = i;

            int j;
            for(j = i + 1; j < arr.length; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            j = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = j;
        }

        sw.stop();
        System.out.println("Время сортировки 100 000 чисел: " + sw.getElapsedTime() + " мс.");
    }

    static class F {
        int i;
        static String s;

        F() {
        }

        void method() {
        }

        static void statMethod() {
        }
    }

    static class TestStatic {
        int count;

        TestStatic() {
        }

        public static void main(String[] args) {
        }

        public int getCount() {
            return this.count;
        }

        public static int factorial(int n) {
            int result = 1;

            for(int i = 1; i <= n; ++i) {
                result *= i;
            }

            return result;
        }
    }

    static class C {
        C() {
        }

        public void method1() {
            method2();
        }

        public static void method2() {
            System.out.println("Исправленная ошибка из задания 3 (статический метод).");
        }
    }

    static class Circle {
        double radius;
        static int numberOfObjects = 0;

        public Circle() {
            this(1.0);
        }

        public Circle(double radius) {
            this.radius = radius;
            ++numberOfObjects;
        }

        public double getArea() {
            return Math.PI * this.radius * this.radius;
        }
    }

    static class StopWatch {
        private long startTime = System.currentTimeMillis();
        private long endTime;

        public StopWatch() {
        }

        public void start() {
            this.startTime = System.currentTimeMillis();
        }

        public void stop() {
            this.endTime = System.currentTimeMillis();
        }

        public long getStartTime() {
            return this.startTime;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public long getElapsedTime() {
            return this.endTime - this.startTime;
        }
    }
}
