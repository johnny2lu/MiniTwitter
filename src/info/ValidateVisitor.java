package info;

import data.User;
import data.UserGroup;

import java.util.Set;

public class ValidateVisitor implements Visitor {
    // check for spaces
    String s = " ";
    private boolean isValid = true;
    private Set<User> users;

    public ValidateVisitor(Set<User> users) {
        this.users = users;
    }

    @Override
    public void visit(UserGroup visitor) {
        if (visitor.toString().contains(s)) {
            isValid = false;
        }
    }

    @Override
    public void visit(User visitor) {
        if (visitor.toString().contains(s) || !users.contains(visitor)) {
            isValid = false;
        }
    }

    public boolean isValid() {
        return isValid;
    }
}
