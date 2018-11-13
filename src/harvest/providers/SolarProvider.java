package harvest.providers;

import harvest.abstracts.Provider;

public class SolarProvider extends Provider {

    public SolarProvider(String id, double energyOutput) {
        super(id, energyOutput);
    }

    @Override
    public String getType() {
        return "Solar";
    }
}
