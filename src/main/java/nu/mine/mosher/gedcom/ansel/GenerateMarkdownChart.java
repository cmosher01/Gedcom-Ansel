package nu.mine.mosher.gedcom.ansel;

import java.util.Objects;

public class GenerateMarkdownChart {
    public static void main(final String... args) {
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("|    | _0  | _1  | _2  | _3  | _4  | _5  | _6  | _7  | _8  | _9  | _A  | _B  | _C  | _D  | _E  | _F  |");
        System.out.println("|---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|");

        for (int hi = 0x08; hi < 0x10; ++hi) {
            System.out.print(String.format("| %1x_ |",hi));
            for (int lo = 0x00; lo < 0x10; ++lo) {
                final int ansel = (hi << 4) | lo;
                final Integer c = AnselCharacterMap.map.get(ansel);
                if (Objects.isNull(c)) {
                    System.out.print(String.format("%19s","|"));
                } else {
                    if (0 <= c) {
                        System.out.print(String.format(" &#x%04x;<br>%04X |", c, c));
                    } else {
                        System.out.print(String.format("%19s","* |"));
                    }
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.flush();
    }
}
