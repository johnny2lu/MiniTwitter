package info;

import data.User;
import data.UserGroup;

public class ValidateVisitor implements Visitor {
    // check for spaces
    String s = " ";
    private boolean isValid = true;

    @Override
    public void visit(UserGroup visitor) {
        if (visitor.toString().contains(s)) {
            isValid = false;
        }
    }

    @Override
    public void visit(User visitor) {
        if (visitor.toString().contains(s)) {
            isValid = false;
        }
    }

    public boolean isValid() {
        return isValid;
    }
}
