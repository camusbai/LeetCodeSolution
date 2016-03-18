package camusbai.leetcode.environment;

import java.util.Arrays;

/**
 * Parent class for Problem 278 First Bad Version
 */
public class VersionControl {
    private final boolean[] existingVersion;

    public boolean isBadVersion(int version) {
        return existingVersion[version];
    }

    public VersionControl(boolean[] existingVersion) {
        this.existingVersion = existingVersion;

        boolean bad = false;
        for (int i=0;i<this.existingVersion.length;++i) {
            if (bad)
                this.existingVersion[i] = true;
            else {
                if (this.existingVersion[i] == true)
                    bad = true;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(existingVersion);
    }
}
