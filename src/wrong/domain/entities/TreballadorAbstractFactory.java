package wrong.domain.entities;

import java.util.function.Supplier;

public final class TreballadorAbstractFactory {

    private final Supplier<AbstractTreballador> abstractTreballadorSupplierMixin;

    public TreballadorAbstractFactory(Supplier<AbstractTreballador> abstractTreballadorSupplierMixin) {
        this.abstractTreballadorSupplierMixin = abstractTreballadorSupplierMixin;
    }

    public AbstractTreballador getTreballador(){
        return this.abstractTreballadorSupplierMixin.get();
    }

}
