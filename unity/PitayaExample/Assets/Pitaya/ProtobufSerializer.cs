using System;
using System.Text;
using Google.Protobuf;

namespace Pitaya
{
    public static class ProtobufSerializer
    {
        public static byte[] Encode(IMessage message, PitayaSerializer serializer)
        {
            if (PitayaSerializer.Protobuf == serializer)
            {
                return message.ToByteArray();
            }
            
            var jsf = new JsonFormatter(new JsonFormatter.Settings(true));
            var jsonString = jsf.Format(message);
            
            return Encoding.UTF8.GetBytes(jsonString);
        }
        
        public static IMessage Decode(byte[] data, Type type, PitayaSerializer serializer)
        {
            if (PitayaSerializer.Protobuf == serializer)
            {
                var res = (IMessage) Activator.CreateInstance(type);
                res.MergeFrom(data);
                return res;
            }
            
            var stringified = Encoding.UTF8.GetString(data);
            return (IMessage)SimpleJson.SimpleJson.DeserializeObject(stringified, type);  
        }
    }
}