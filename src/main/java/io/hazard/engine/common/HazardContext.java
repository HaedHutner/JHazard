package io.hazard.engine.common;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.hazard.engine.api.game.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class HazardContext {

    private static final String HAZARD_LOGO = "                         __    _\n" +
            "                    _wr\"\"        \"-q__\n" +
            "                 _dP                 9m_\n" +
            "               _#P                     9#_\n" +
            "              d#@                       9#m\n" +
            "             d##                         ###\n" +
            "            J###                         ###L\n" +
            "            {###K                       J###K\n" +
            "            ]####K      ___aaa___      J####F\n" +
            "        __gmM######_  w#P\"\"   \"\"9#m  _d#####Mmw__\n" +
            "     _g##############mZ_         __g##############m_\n" +
            "   _d####M@PPPP@@M#######Mmp gm#########@@PPP9@M####m_\n" +
            "  a###\"\"          ,Z\"#####@\" '######\"\\g          \"\"M##m\n" +
            " J#@\"             0L  \"*##     ##@\"  J#              *#K\n" +
            " #\"               `#    \"_gmwgm_~    dF               `#_\n" +
            "7F                 \"#_   ]#####F   _dK                 JE\n" +
            "]                    *m__ ##### __g@\"                   F\n" +
            "                       \"PJ#####LP\"\n" +
            " `                       0######_                      '\n" +
            "                       _0########_\n" +
            "     .               _d#####^#####m__              ,\n" +
            "      \"*w_________am#####P\"   ~9#####mw_________w*\"\n" +
            "          \"\"9@#####@M\"\"           \"\"P@#####@M\"\"\n" +
            "         _   _   ___   ______  ___  ______ ______\n" +
            "        | | | | / _ \\ |___  / / _ \\ | ___ \\|  _  \\\n" +
            "        | |_| |/ /_\\ \\   / / / /_\\ \\| |_/ /| | | |\n" +
            "        |  _  ||  _  |  / /  |  _  ||    / | | | |\n" +
            "        | | | || | | |./ /___| | | || |\\ \\ | |/ /\n" +
            "        \\_| |_/\\_| |_/\\_____/\\_| |_/\\_| \\_||___/";

    private Game game;

    private Logger logger = LoggerFactory.getLogger(HazardContext.class);

    @Inject
    public HazardContext(Game game) {
        this.game = game;
    }

    public void init() {
        for (String logoLine : HAZARD_LOGO.split("\n")) {
            logger.info(logoLine);
        }
        if ( game.init() ) {
            game.run();
        }
    }
}
