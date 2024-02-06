public class Partner {
    private String name;
    private Partner partner;

    public Partner(String name) {
        this.name = name;
        this.partner = null;
    }

    public String getName() {
        return name;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner newPartner) {
        if (this.partner != null && newPartner != this.partner) {
            this.partner.partner = null;
        }
        this.partner = newPartner;
        if (newPartner != null && newPartner.getPartner() != this) {
            newPartner.setPartner(this);
        }
    }

    @Override
    public String toString() {
        if (partner != null) {
            return name + " is partnered with " + partner.getName();
        } else {
            return name + " has no partner";
        }
    }

}
