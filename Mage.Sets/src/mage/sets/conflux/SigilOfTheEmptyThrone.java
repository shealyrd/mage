/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */

package mage.sets.conflux;

import java.util.UUID;
import mage.Constants.CardType;
import mage.Constants.Rarity;
import mage.MageInt;
import mage.ObjectColor;
import mage.abilities.common.SpellCastTriggeredAbility;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.filter.FilterCard;
import mage.game.permanent.token.Token;

/**
 *
 * @author Loki, North
 */
public class SigilOfTheEmptyThrone extends CardImpl<SigilOfTheEmptyThrone> {

    private static final FilterCard filter = new FilterCard("an enchantment spell");

    static {
        filter.getCardType().add(CardType.ENCHANTMENT);
    }

    public SigilOfTheEmptyThrone(UUID ownerId) {
        super(ownerId, 18, "Sigil of the Empty Throne", Rarity.RARE, new CardType[]{CardType.ENCHANTMENT}, "{3}{W}{W}");
        this.expansionSetCode = "CON";
        this.color.setWhite(true);

        this.addAbility(new SpellCastTriggeredAbility(new CreateTokenEffect(new AngelToken()), filter, false));
    }

    public SigilOfTheEmptyThrone(final SigilOfTheEmptyThrone card) {
        super(card);
    }

    @Override
    public SigilOfTheEmptyThrone copy() {
        return new SigilOfTheEmptyThrone(this);
    }

}

class AngelToken extends Token {
    public AngelToken() {
        super("Angel", "4/4 white Angel creature token with flying");
        cardType.add(CardType.CREATURE);
        color = ObjectColor.WHITE;
        subtype.add("Angel");
        power = new MageInt(4);
        toughness = new MageInt(4);
        addAbility(FlyingAbility.getInstance());
    }
}