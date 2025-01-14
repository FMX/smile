/*
 * Copyright (c) 2010-2021 Haifeng Li. All rights reserved.
 *
 * Smile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Smile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Smile.  If not, see <https://www.gnu.org/licenses/>.
 */
package smile.test.data;

import org.apache.commons.csv.CSVFormat;
import smile.io.Read;
import smile.util.Paths;

/**
 *
 * @author Haifeng
 */
public class MNIST {

    public static double[][] x;
    public static int[] y;

    static {
        try {
            CSVFormat format = CSVFormat.Builder.create().setDelimiter(' ').build();
            x = Read.csv(Paths.getTestData("mnist/mnist2500_X.txt"), format).toArray();
            y = Read.csv(Paths.getTestData("mnist/mnist2500_labels.txt"), format).column(0).toIntArray();
        } catch (Exception ex) {
            System.err.println("Failed to load 'MNIST': " + ex);
            System.exit(-1);
        }
    }
}
