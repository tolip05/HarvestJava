package harvest.providers;

import harvest.abstracts.Provider;

public class PressureProvider extends Provider {


    public PressureProvider(String id, double energyOutput) {
        super(id, energyOutput * 1.5);

    }

    @Override
    public String getType() {
        return "Pressure";
    }
}
