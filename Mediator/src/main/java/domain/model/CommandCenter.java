package domain.model;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class CommandCenter {

    private final Headquarters headquarters;

    public void attackBacksWithSecondArmy() {
        System.out.println("Order from command center to army: 2 attack back!");
        headquarters.attackBacks(1);
    }

    public boolean makeDecision(String information) {
        boolean decision = new Random().nextBoolean();
        System.out.println("Command center: decision for information: " + information + " is: " + (decision ? "possitive." : "negative."));
        return new Random().nextBoolean();
    }

    public void handleInformation(String information) {
        System.out.println("We command center got information; " + information);
    }

    public void bindEnemysForcesNearTheSwamps(int armyNumber) {
        System.out.println("We command center make order bind enemies forces near the swamps to army: " + (armyNumber+1));
        headquarters.bindEnemysForcesNearTheSwamps(armyNumber);
    }
}
