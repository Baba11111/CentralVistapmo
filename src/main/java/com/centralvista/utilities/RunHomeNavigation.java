/**
 * @author surendragangwar
 * @since 27-Oct-2026
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.utilities;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RunHomeNavigation {
}
