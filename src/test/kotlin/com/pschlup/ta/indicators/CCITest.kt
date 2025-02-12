package com.pschlup.ta.indicators

import com.google.common.truth.Truth.assertThat
import com.pschlup.ta.helpers.FakeTimeSeries
import org.junit.jupiter.api.Test

internal class CCITest {

  @Test
  fun `should compute value`() {
    val timeSeries = FakeTimeSeries.of(typicalPrices)
    val cci = timeSeries.cci(20)

    assertThat(cci.valueAt(0))
      .isWithin(0.0001).of(-72.7273)
    assertThat(cci.valueAt(1))
      .isWithin(0.0001).of(-128.6)
  }
}

private val typicalPrices = doubleArrayOf(
  23.98, 23.92, 23.79, 23.67, 23.54,
  23.36, 23.65, 23.72, 24.16, 23.91,
  23.81, 23.92, 23.74, 24.68, 24.94,
  24.93, 25.10, 25.12, 25.20, 25.06,
  24.50, 24.31, 24.57, 24.62, 24.49,
  24.37, 24.41, 24.35, 23.75, 24.09
)
