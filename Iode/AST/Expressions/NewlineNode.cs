﻿using System.Reflection.Emit;

namespace Iode.AST
{
    /// <summary>
    /// Emptyness
    /// </summary>
    public class NewlineNode : Expression
    {
        public override NodeType type
        {
            get
            {
                return NodeType.NULL;
            }
        }
        public override void generate(ILGenerator ilg)
        {
        }

        public override string ToString()
        {
            return null;
        }
    }
}