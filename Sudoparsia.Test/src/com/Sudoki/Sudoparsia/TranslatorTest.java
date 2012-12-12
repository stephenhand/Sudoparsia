package com.Sudoki.Sudoparsia;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedCharacterIterator.Attribute;
import java.text.AttributedString;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Sudoki.Sudoparsia.config.PatternException;

public class TranslatorTest {
	
	private Translator _t;
	private AttributedString _aic1x3,_d3multi;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_t=new Translator();
		_t.setData(ConfigProviderFactory.Build().Load());
		_aic1x3=new AttributedString("AIC1 !7[R8C5]=>7[R5C5]->!7[R5C9]=>7[R9C9]");
		_aic1x3.addAttribute(TextAttribute.BACKGROUND, Color.BLACK);
		_aic1x3.addAttribute(TextAttribute.FOREGROUND, Color.GRAY);
		
		_d3multi=new AttributedString("D(3) 8[R1C4]...5[R1C4]: !8[R1C4]=>5[R1C4]->!5[R1C2]=>5[R6C2]->!9[R6C2]=>9[R6C6]->!6[R6C6]=>6[R9C6]->!6[R9C5]=>5[R9C5]->!5[R5C5]=>5[R5C3]->!5[R6C2]=>5[R1C2]->!5[R1C4]");
		_d3multi.addAttribute(TextAttribute.BACKGROUND, Color.BLACK, 0, 136);
		_d3multi.addAttribute(TextAttribute.FOREGROUND, Color.GRAY, 0, 5);
		_d3multi.addAttribute(TextAttribute.FOREGROUND, Color.YELLOW, 5, 24);
		_d3multi.addAttribute(TextAttribute.FOREGROUND, Color.GRAY, 24, 62);
		_d3multi.addAttribute(TextAttribute.FOREGROUND, Color.RED, 62, 146);
		
		_d3multi.addAttribute(TextAttribute.BACKGROUND, new Color(0x006400), 136, 146);
		_d3multi.addAttribute(TextAttribute.BACKGROUND, Color.BLACK, 146, 165);
		_d3multi.addAttribute(TextAttribute.FOREGROUND, Color.GRAY, 146, 165);		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void DecodeLine_AIC1x3_DoesNotThrow() {
		AttributedCharacterIterator it=_aic1x3.getIterator();
		try {
			_t.DecodeLine(it, it.getBeginIndex(),it.getEndIndex());
		} catch (PatternException e) {
			// TODO Auto-generated catch block
			org.junit.Assert.fail();
		}
		
	}
	
	@Test
	public void DecodeLine_D3Multi_DoesNotThrow() {
		AttributedCharacterIterator it=_d3multi.getIterator();
		try {
			_t.DecodeLine(it, it.getBeginIndex(),it.getEndIndex());
		} catch (PatternException e) {
			// TODO Auto-generated catch block
			org.junit.Assert.fail();
		}
		
	}

	@Test
	public void DecodeLine_D3Multi_HasCorrectSections() {
		AttributedCharacterIterator it=_d3multi.getIterator();
		try {
			DecodedLine dcl=_t.DecodeLine(it, it.getBeginIndex(),it.getEndIndex());
			int sections=dcl.getColorSections().size();
			if (sections!=6)
			{
				org.junit.Assert.fail("Incorrect number of sections");
			}			
		} catch (PatternException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
