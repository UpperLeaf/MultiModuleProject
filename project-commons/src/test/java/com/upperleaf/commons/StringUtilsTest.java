package com.upperleaf.commons;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    public void test_hello_return() {
        assertThat(StringUtils.getHelloString()).isEqualTo("Hello");
    }
}