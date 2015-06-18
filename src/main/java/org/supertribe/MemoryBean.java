package org.supertribe;

import org.tomitribe.crest.api.Command;
import org.tomitribe.crest.api.Default;
import org.tomitribe.crest.api.Option;
import org.tomitribe.crest.connector.api.CrestListener;
import org.tomitribe.util.Size;
import org.tomitribe.util.SizeUnit;

import javax.ejb.MessageDriven;

@MessageDriven(name = "Runtime")
@Command("memory")
public class MemoryBean implements CrestListener {

    @Command
    public void gc() {
        Runtime.getRuntime().gc();
    }

    @Command
    public String free(@Option({"unit", "u"}) @Default("MEGABYTES") SizeUnit unit) {
        final long bytes = Runtime.getRuntime().freeMemory();
        final Size size = new Size(unit.convert(bytes, SizeUnit.BYTES), unit);
        return size.toString();
    }

    @Command
    public String max(@Option({"unit", "u"}) @Default("MEGABYTES") SizeUnit unit) {
        final long bytes = Runtime.getRuntime().maxMemory();
        final Size size = new Size(unit.convert(bytes, SizeUnit.BYTES), unit);
        return size.toString();
    }

    @Command
    public String total(@Option({"unit", "u"}) @Default("MEGABYTES") SizeUnit unit) {
        final long bytes = Runtime.getRuntime().totalMemory();
        final Size size = new Size(unit.convert(bytes, SizeUnit.BYTES), unit);
        return size.toString();
    }

}
