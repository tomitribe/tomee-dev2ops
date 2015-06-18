package org.supertribe;

import org.tomitribe.crest.api.Command;
import org.tomitribe.crest.api.StreamingOutput;
import org.tomitribe.crest.connector.api.CrestListener;

import javax.ejb.MessageDriven;
import javax.inject.Inject;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

@MessageDriven
@Command("control")
public class ControlBean implements CrestListener {

    @Inject
    private Control control;

    @Command
    public String add(final String user, final Integer status) {
        control.response(user, status);
        return String.format("Forcing %s responses to user %s%n", status, user);
    }

    @Command
    public String remove(final String user) {
        control.clear(user);
        return String.format("Clearing restrictions for user %s%n", user);
    }

    @Command
    public StreamingOutput list() {
        return new StreamingOutput() {
            @Override
            public void write(OutputStream outputStream) throws IOException {
                final Map<String, Integer> users = control.getUsers();
                for (final Map.Entry<String, Integer> entry : users.entrySet()) {
                    System.out.printf(" - %s = %s%n", entry.getKey(), entry.getValue());
                }
            }
        };
    }

}
