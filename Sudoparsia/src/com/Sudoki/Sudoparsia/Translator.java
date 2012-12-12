package com.Sudoki.Sudoparsia;

import java.awt.Color;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import com.Sudoki.Sudoparsia.config.*;

public class Translator {
	
	private IConfigData _data;
	
	public String Sudopediarize(AttributedString sudoki) throws PatternException, ShapeException {
		IConfigProvider cp=ConfigProviderFactory.Build();
		setData(cp.Load());
		
		AttributedCharacterIterator it=sudoki.getIterator();
		it.first();
		while (it.current()!=AttributedCharacterIterator.DONE)
		{
			int iStart=it.getIndex(),iEnd;
			while (it.current()!='\n')
			{
				it.next();
			}
			iEnd=it.getIndex();
			DecodedLine dl=DecodeLine(it,iStart,iEnd);
			
		}
		return "Hello";
	}
	
	public DecodedLine DecodeLine(AttributedCharacterIterator it, int iLineStart, int iLineEnd) throws PatternException
	{
		DecodedLine dl=new DecodedLine();

		it.setIndex(iLineStart);
		dl.setLoop(findLineLoopType(extractString(it,iLineEnd-iLineStart)));
		it.setIndex(iLineStart);
		while (it.current()!=AttributedCharacterIterator.DONE && it.getIndex()<iLineEnd)
		{
			Color bgc=(Color)it.getAttribute(TextAttribute.BACKGROUND),
					fgc=(Color)it.getAttribute(TextAttribute.FOREGROUND);
			int iColorRun=Math.min(it.getRunLimit(TextAttribute.BACKGROUND), it.getRunLimit(TextAttribute.FOREGROUND))-it.getIndex();
			ColourSection cs=new ColourSection();
			cs.setState(getData().getColourSettings().getState(fgc, bgc));
			String colourText=extractString(it,iColorRun);
			cs.setText(colourText);
			it.setIndex(it.getIndex()+iColorRun);
			cs.Decode(_data.getPatternSettings());
			
			
			dl.getColorSections().add(cs);
			
		}
		return dl;
	}

    public String InterpretLine(DecodedLine line)
    {

        return null;
    }

    public String GenerateCommentary(DecodedLine line)
    {

        return null;
    }


	
	private LoopType findLineLoopType(String colourText) throws PatternException
	{
		return getData().getPatternSettings().getLoopTypeFromLine(colourText);
	}
	
	private String extractString(AttributedCharacterIterator it, int runLength)
	{
		char[] acBuff=new char[runLength];
		int iStart=it.getIndex();
		if (runLength>0 && it.current()!=AttributedCharacterIterator.DONE)
		{
			acBuff[0]=it.current();
			for (int i=1;i<runLength && it.current()!=AttributedCharacterIterator.DONE;i++)
			{
				acBuff[i]=it.next();
			}
		}
		it.setIndex(iStart);
		return String.copyValueOf(acBuff);
	}

	public IConfigData getData() {
		return _data;
	}

	public void setData(IConfigData _data) {
		this._data = _data;
	}
	

	

	
}
