package by.gsu.training.final1;

public class Trip {
    private final int DAILY_ALLOWANCE;
    private String account;
    private int transportationExpenses;
    private int durationInDays;

    public Trip() {
        DAILY_ALLOWANCE = 1234;
    }

    public Trip(String name) {
        this(name, 7);
    }

    public Trip(String name, int durationInDays) {
        this(name, 1000, 0, durationInDays);
    }

    public Trip(String account, int dailyAllowance, int transportationExpenses, int durationInDays) {
        this.account = account;
        this.DAILY_ALLOWANCE = dailyAllowance;
        this.transportationExpenses = transportationExpenses;
        this.durationInDays = durationInDays;
    }

    public int getTotal() {
        return transportationExpenses + DAILY_ALLOWANCE * durationInDays;
    }

    public void show() {
        System.out.println("аккаунт = " + account);
        System.out.println("ставка = " + toByn(DAILY_ALLOWANCE));
        System.out.println("транспорт = " + toByn(transportationExpenses));
        System.out.println("дней = " + durationInDays);
        System.out.println("всего = " + toByn(this.getTotal()));
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%d;%s",
            account,
            toByn(transportationExpenses),
            durationInDays,
            toByn(this.getTotal())
        );
    }

    private String toByn(int money) {
        int rubles = money / 100;
        int cents = money % 100;
        return String.format("%d.%02d", rubles, cents);
    }

    public int getDailyAllowance() {
        return DAILY_ALLOWANCE;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTransportationExpenses() {
        return transportationExpenses;
    }

    public void setTransportationExpenses(int transportationExpenses) {
        this.transportationExpenses = transportationExpenses;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }
}
