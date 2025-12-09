using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.CardGenerator
{
    /// <summary>
    /// Query options for the Card Generator API
    /// </summary>
    public class CardGeneratorQueryOptions
    {
        /// <summary>
        /// The brand of the card (e.g., visa, mastercard, amex, discover)
        /// Example: visa
        /// </summary>
        [JsonProperty("brand")]
        public string Brand { get; set; }

        /// <summary>
        /// The number of test card numbers to generate
        /// Example: 5
        /// </summary>
        [JsonProperty("count")]
        public string Count { get; set; }
    }
}
