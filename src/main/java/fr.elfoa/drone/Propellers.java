package fr.elfoa.drone;

import fr.elfoa.drone.Qualifiers.LithiumClassic;
import fr.elfoa.drone.Qualifiers.PropellersFour;

import javax.inject.Inject;

/**
 * @author Pierre Colomb
 */
@PropellersFour
public class Propellers implements IPropellers{

    private Integer number = 4;

    @Inject
    @LithiumClassic
    private IBattery battery;

    private ConsumptionCalculator calculator = new ConsumptionCalculator();

    private Boolean isRunning = false;

    @Override
    public void setBattery(Battery battery){
        this.battery = battery;
    }

    @Override
    public void start(){
        battery.use(calculator.getConsumption(number));
        isRunning = true;
    }

    @Override
    public void stop(){
        isRunning = false;
    }

    @Override
    public Integer getNumberOfPropelle() {
        return number;
    }

    @Override
    public Boolean getRunning() {
        return isRunning;
    }
}
