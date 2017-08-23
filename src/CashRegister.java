public class CashRegister {
    private double cashInRegister;   // the amount of cash in the register
    private int economicalSold;      // the amount of economical lunches sold
    private int gourmetSold;         // the amount of gourmet lunches sold

    public CashRegister() {
        this.cashInRegister = 1000;
    }

    public double payEconomical(double cashGiven) {
        double change = payMeal("Economical", cashGiven);
        return change;

    }

    public double payGourmet(double cashGiven) {
        double change = payMeal("Gourmet", cashGiven);
        return change;
    }

    private double payMeal(String mealType, double cashGiven) {
        double change;
        double economicalCost = 2.5;
        double gourmetCost = 4.00;
        double mealCost;

        if (mealType.equals("Economical")) {
            mealCost = economicalCost;
        } else {
            mealCost = gourmetCost;
        }

        if (cashGiven >= mealCost) {
            this.cashInRegister += mealCost;
            increaseSoldRecord(mealType);
            change = cashGiven - mealCost;
            return change;
        } else {
            return cashGiven;
        }
    }

    private void increaseSoldRecord(String mealType) {
        if (mealType.equals("Economical")) {
            this.economicalSold++;
        } else {
            this.gourmetSold++;
        }
    }

    public boolean payEconomical(LyyraCard card) {
        boolean paid = payLyyraCard("Economical", card);
        return paid;
    }

    public boolean payGourmet(LyyraCard card) {
        boolean paid = payLyyraCard("Gourmet", card);
        return paid;
    }

    public boolean payLyyraCard(String mealType, LyyraCard card) {
        double costEconomical = 2.5;
        double costGourmet = 4;
        double costMeal;

        if (mealType.equals("Economical")) {
            costMeal = costEconomical;
        } else {
            costMeal = costGourmet;
        }

        if (card.balance() >= costMeal) {
            card.pay(costMeal);
            increaseSoldRecord(mealType);
            return true;
        } else {
            return false;
        }

    }

    public void loadMoneyToCard(LyyraCard card, double amountToLoad){
        while(true){
            if(amountToLoad > 0){
                this.cashInRegister += amountToLoad;
                card.loadMoney(amountToLoad);
                break;
            }
            else{
                System.out.print("Error amount to load must be greater than 0");
            }
        }
    }

    public String toString() {
        return "money in register " + cashInRegister + " economical lunches sold: " + economicalSold + " gourmet lunches sold: " + gourmetSold;
    }
}