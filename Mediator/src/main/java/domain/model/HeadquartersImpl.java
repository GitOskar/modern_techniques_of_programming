package domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class HeadquartersImpl implements Headquarters {

    private Map<Integer, Army> armies;
    private CommandCenter commandCenter;
    private Intelligence intelligence;

    public HeadquartersImpl() {
        armies = new HashMap<>();
    }

    @Override
    public void sendInformationToArmyAboutEnemyMove(int armyNumber, String direction) {
        String message = "Enemy are moving to " + direction;
        commandCenter.handleInformation(message);
        armies.get(armyNumber).handleInformation(message);
    }

    @Override
    public void attackBacks(int armyNumber) {
        armies.get(armyNumber).attackBacks();
    }

    @Override
    public void bindEnemysForcesNearTheSwamps(int armyNumber) {
        armies.get(armyNumber).bindEnemysForcesNearTheSwamps();
    }

    @Override
    public void sendInformationAboutArmyIsAttackingLeftFlankToAnotherArmy(int armyFrom, int armyTo) {
        String message = "Army " + (armyFrom + 1) + " is attacking the left flank";
        commandCenter.handleInformation(message);
        armies.get(armyTo).handleInformation(message);
    }

    @Override
    public void addArmy(Army army) {
        this.armies.put(army.getNumber(), army);
    }
}
