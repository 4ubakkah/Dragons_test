package org.dragons;

import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.runner.RunWith;

@RunWith(ClasspathSuite.class)
@ClasspathSuite.ClassnameFilters({".*Test", "!.*ITest"})
public class UnitTestsRunner {

}