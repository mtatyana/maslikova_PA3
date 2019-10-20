public interface Question {
    public double getAnswer();

    public static class AdditionQuestion implements Question {
        private final double a;
        private final double b;

        public AdditionQuestion(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double getAnswer() {
            return a + b;
        }

        public String toString() {
            return ((int)a) + " plus " + ((int)b);
        }
    }
    public static class MultiplicationQuestion implements Question {
        private final double a;
        private final double b;

        public MultiplicationQuestion(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double getAnswer() {
            return a * b;
        }

        public String toString() {
            return ((int)a) + " times " + ((int)b);
        }
    }

    public static class SubtractionQuestion implements Question {
        private final double a;
        private final double b;

        public SubtractionQuestion(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double getAnswer() {
            return a - b;
        }

        public String toString() {
            return ((int)a) + " minus " + ((int)b);
        }
    }

    public static class DivisionQuestion implements Question {
        private final double a;
        private final double b;

        public DivisionQuestion(double a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public double getAnswer() {
            return a / b;
        }

        public String toString() {
            return ((int)a) + " divided by " + ((int)b);
        }
    }
    public static Question from(int diffLevel, int pType) {
        double a = getParam(diffLevel);
        double b = getParam(diffLevel);
        if (pType == 5)
            pType = Driver.rng.nextInt(4)+1;



        switch (pType) {
            case 1:
                return new AdditionQuestion(a, b);
            case 2:
                return new MultiplicationQuestion(a, b);
            case 3:
                return new SubtractionQuestion(a, b);
            case 4:
                return new DivisionQuestion(a, b);
            default:
                return null;
        }
    }

    static int getParam(int diffLevel) {
        switch (diffLevel){
            case 1: return  Driver.rng.nextInt(9)+1;
            case 2: return  Driver.rng.nextInt(90)+10;
            case 3: return  Driver.rng.nextInt(900)+100;
            case 4: return  Driver.rng.nextInt(9000)+1000;
            default: return -1;
        }
    }

    public default boolean isCorrect(double resp) {
        return resp == this.getAnswer();
    }
    public default void ask(){
        System.out.println("How much is " + this + "?");
    }
}
