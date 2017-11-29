/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2017 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms
 * of the GNU Affero General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Affero General Public License for more details. You should have received a copy of
 * the GNU Affero General Public License along with this program. If not, see
 * http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org. 
 */

package org.openlmis.util.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.util.UUID;

public class UuidConverterTest {

  private UuidConverter uuidConverter = new UuidConverter();

  @Test
  public void shouldConvertStringToUuid() {
    String uuidInput = "de25d55f-0f59-4deb-9889-ae90184e8d3b";
    UUID actual = uuidConverter.convert(UUID.class, uuidInput);

    assertEquals(UUID.fromString(uuidInput), actual);
  }

  @Test
  public void shouldReturnNullOnNullInput() {
    UUID actual = uuidConverter.convert(UUID.class, null);

    assertNull(actual);
  }

  @Test
  public void shouldReturnNullOnEmptyInput() {
    UUID actual = uuidConverter.convert(UUID.class, "");

    assertNull(actual);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldNotAcceptOtherTypesThanUuid() {
    uuidConverter.convert(Integer.class, "de25d55f-0f59-4deb-9889-ae90184e8d3b");
  }
}
